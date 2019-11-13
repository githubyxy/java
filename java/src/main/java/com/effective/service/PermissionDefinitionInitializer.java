package com.effective.service;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.effective.service.transaction.IPermissionTransactionService;

@Component
public class PermissionDefinitionInitializer {

	@Resource(name =  "permissionTransactionService")
	private IPermissionTransactionService permissionTransactionService;
	
	@PostConstruct
	public void initPermissionDefinitions() {
		new Timer().schedule(new TimerTask() {

			@Override
			public void run() {
				try {
					permissionTransactionService.loadPermissionDefinitions();
				} catch (Exception e) {
				}
			}
		}, 5000);
	}
}
