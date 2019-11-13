package com.effective.service.transaction;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.effective.bean.PermissionsXml;
import com.effective.bean.PermissionsXml.AbstractPerm;
import com.effective.bean.PermissionsXml.Button;
import com.effective.bean.PermissionsXml.Module;
import com.effective.bean.PermissionsXml.Perm;
import com.effective.dao.mapper.gen.PrivilegeDOMapper;
import com.effective.dao.po.PrivilegeDO;
import com.effective.dao.po.PrivilegeDOExample;
import com.effective.service.PermissionDefinitionInitializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import scala.noinline;
import scala.annotation.meta.param;

@Service(value = "permissionTransactionService")
public class PermissionTransactionService implements IPermissionTransactionService {

	private Logger Logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private PrivilegeDOMapper privilegeDOMapper;
	
	private int order = -1;
	
	@Override
	public void loadPermissionDefinitions() {
		
		Logger.info("开始了");
		
		XStream xs = new XStream(new DomDriver());
		XStream.setupDefaultSecurity(xs);
		xs.allowTypes(new Class[]{PermissionsXml.class});
		xs.processAnnotations(PermissionsXml.class);
		xs.autodetectAnnotations(true);
		xs.allowTypesByWildcard(new String[] {
			    "com.effective.**"
			});
		
		InputStream resourceAsStream = this.getClass().getResourceAsStream("nova-privilege.xml");
		PermissionsXml pxOperator = (PermissionsXml) xs.fromXML(resourceAsStream);
		Logger.info("xml加载完成");
		// get globalVersion first, if xml files do not change, return immediately
		int globalVersion = pxOperator.getVersion();

		// process xml files
		order = -1;

		this.postDeserialize(pxOperator);
		if (!PermDefinesAnalyst.verify(pxOperator)) {
			return;
		}
		List<PrivilegeDO> operatorPerms = new ArrayList<>(PermDefinesAnalyst.permissions);

		// update permission
		PrivilegeDOExample perExample = new PrivilegeDOExample();
		privilegeDOMapper.deleteByExample(perExample);

		Logger.info("删除");
		
		for (PrivilegeDO permission : operatorPerms) {
			privilegeDOMapper.insert(permission);
		}
		Logger.info("结束了");
	}
	
	
	private void postDeserialize(PermissionsXml permissionXml){
		Iterator<Module> it = permissionXml.getModules().iterator();
		this.post4Module(it, null);
	}

	private void post4Module(Iterator<Module> it, Module parent){
		while(it.hasNext()){
			order++;
			Module module = it.next();
			module.setParent(parent == null ? "" : parent.getKey());
			module.setOrder(order);
			List<Module> module_list = module.getModules();
			List<Button> button_list = module.getButtons();
			if(!CollectionUtils.isEmpty(module_list)){
				this.post4Module(module_list.iterator(), module);
			}
			if(!CollectionUtils.isEmpty(button_list)){
				this.post4Button(button_list.iterator(),  module);
			}
		}
	}

	private <T extends AbstractPerm> void post4Button(Iterator<Button> it, T parent){
		while(it.hasNext()){
			order++;
			Button button = it.next();
			button.setParent(parent.getKey());
			button.setOrder(order);
			List<Button> button_list = button.getButtons();
			List<Perm> perm_list = button.getPerms();
			if(!CollectionUtils.isEmpty(button_list)){
				this.post4Button(button_list.iterator(),  button);
			}
			if(!CollectionUtils.isEmpty(perm_list)){
				this.post4Perm(perm_list.iterator(), button);
			}
		}
	}

	private void post4Perm(Iterator<Perm> it, Button parent){
		while(it.hasNext()){
			order++;
			Perm perm = it.next();
			perm.setParent(parent.getKey());
			perm.setOrder(order);
		}
	}

	static class PermDefinesAnalyst {

		static Set<String> urls = new HashSet<>();
		static Set<String> keys = new HashSet<>();
		static List<PrivilegeDO> permissions = new LinkedList<>();
		private static boolean passed;

		public static void reset() {
			urls.clear();
			keys.clear();
			permissions.clear();
		}

		public static boolean verify(PermissionsXml px) {
			reset();
			passed = true;
			for (Module mdl : px.getModules()) {
				traverseModule(mdl);
			}
			return passed;
		}

		private static void traverseModule(Module mdl) {
			if (StringUtils.isBlank(mdl.getKey()) || StringUtils.isBlank(mdl.getName())) {
				passed = false;
			} else {
				addKey(mdl.getKey());
			}
//			if (StringUtils.isNotBlank(mdl.getUrl())) {
//				addUrl(mdl.getUrl());
//			}
			addPermission(mdl.getKey(), mdl.getUrl(), mdl.getParent(), mdl.getName(), mdl.getSort(), mdl.getOrder(), mdl.getIsMenu(), mdl.getIcon());
			if (!CollectionUtils.isEmpty(mdl.getModules())) {
				for (Module m : mdl.getModules()) {
					traverseModule(m);
				}
			}
			if (!CollectionUtils.isEmpty(mdl.getButtons())) {
				for (Button btn : mdl.getButtons()) {
					traverseButton(btn);
				}
			}
		}

		private static void traverseButton(Button btn) {
//			button must have a key
			if (StringUtils.isBlank(btn.getKey())) {
				passed = false;
			}
			addKey(btn.getKey());
			addUrl(btn.getUrl());
			addPermission(btn.getKey(), btn.getUrl(), btn.getParent(), btn.getName(), btn.getSort(), btn.getOrder(), btn.getIsMenu(), btn.getIcon());
			if (!CollectionUtils.isEmpty(btn.getButtons())) {
				for (Button subbtn : btn.getButtons()) {
					traverseButton(subbtn);
				}
			}
			if (!CollectionUtils.isEmpty(btn.getPerms())) {
				for (Perm p : btn.getPerms()) {
					addKey(p.getKey());
					addPermission(p.getKey(), null, p.getParent(), p.getName(), p.getSort(), p.getOrder(), "0", null);
				}
			}
		}

		private static void addKey(String key) {
			if (StringUtils.isBlank(key)) {
				return;
			}
			if (keys.contains(key)) {
				passed = false;
			} else {
				keys.add(key);
			}
		}

		private static void addUrl(String url) {
			if (StringUtils.isBlank(url)) {
				return;
			}
			urls.add(url);
		}

		private static void addPermission(String key, String url, String parent, String name, String sort, int order, String isMenu, String icon) {
			if (StringUtils.isBlank(key)) {
				return;
			}
			PrivilegeDO p = new PrivilegeDO();
			
			p.setPrivilegeUuid(key);
			p.setPrivilegeName(name);
			p.setPrivilegeSort(Integer.valueOf(sort));
			p.setRoute(url);
			
			p.setParentPrivilegeUuid(parent);
			p.setIsMenu("1".equals(isMenu));
			p.setIcon(icon);
			p.setGmtCreate(new Date());
			p.setGmtModify(new Date());
			permissions.add(p);
		}
	}
}
