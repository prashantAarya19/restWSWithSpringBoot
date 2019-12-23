package com.np.restws.service.impl;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.container.AsyncResponse;

import org.springframework.stereotype.Service;

import com.np.restws.model.CheckList;
import com.np.restws.service.CheckProcessor;

@Service
public class CheckProcessorImpl implements CheckProcessor {

	@Override
	public void processCheck(AsyncResponse response, CheckList checkList) {
		new Thread() {
			@Override
			public void run() {
				if(checkList==null || checkList.getCheck()==null || checkList.getCheck().size()==0) {
					response.resume(new BadRequestException());
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				response.resume(true);
			}
		}.start();
		
	}

	

}
