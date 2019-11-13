package com.effective.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("permissions")
public class PermissionsXml {

	@XStreamAsAttribute private int version;
	@XStreamImplicit private List<Module> modules;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	@XStreamAlias("module")
	public static class Module extends AbstractPerm {
		@XStreamImplicit private List<Module> modules;
		@XStreamImplicit private List<Button> buttons;

		@Override
		public String toString() {
			return "Module [name=" + this.getName() + ", key=" + this.getKey() + "]";
		}

		public List<Module> getModules() {
			return modules;
		}

		public void setModules(List<Module> modules) {
			this.modules = modules;
		}

		public List<Button> getButtons() {
			return buttons;
		}

		public void setButtons(List<Button> buttons) {
			this.buttons = buttons;
		}
		
		
	}

	@XStreamAlias("button")
	public static class Button extends AbstractPerm {
		@XStreamImplicit private List<Perm> perms;
		@XStreamImplicit private List<Button> buttons;
		
		
		@Override
		public String toString() {
			return "Button [name=" + this.getName() + ", key=" + this.getKey() + ", url=" + this.getUrl() + "]";
		}

		public List<Perm> getPerms() {
			return perms;
		}

		public void setPerms(List<Perm> perms) {
			this.perms = perms;
		}

		public List<Button> getButtons() {
			return buttons;
		}
		
		public void setButtons(List<Button> buttons) {
			this.buttons = buttons;
		}

	}

	@XStreamAlias("perm")
	public static class Perm extends AbstractPerm{
		
	}
	public static abstract class AbstractPerm {
		@XStreamAsAttribute private String name;
		@XStreamAsAttribute private String key;
		@XStreamAsAttribute private String sort;
		@XStreamAsAttribute private String url;
		@XStreamAsAttribute private String isMenu;
		@XStreamAsAttribute private String icon;
		
		private String parent;
		private int order;

		@Override
		public String toString() {
			return "Perm [name=" + name + ", key=" + key + ", sort=" + sort + "]";
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getSort() {
			return sort;
		}

		public void setSort(String sort) {
			this.sort = sort;
		}

		public String getParent() {
			return parent;
		}

		public void setParent(String parent) {
			this.parent = parent;
		}

		public int getOrder() {
			return order;
		}

		public void setOrder(int order) {
			this.order = order;
		}
		
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getIsMenu() {
			return isMenu;
		}

		public void setIsMenu(String isMenu) {
			this.isMenu = isMenu;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

	}

}