/**
 * Project Name cmpp-client
 * File Name ConnectRespAction.java
 * Package Name com.lljqiu.tools.cmpp.client.action
 * Create Time 2018年8月31日
 * Create by name：liujie -- email: liujie@lljqiu.com
 * Copyright © 2015, 2017, www.lljqiu.com. All rights reserved.
 */
package com.lljqiu.tools.cmpp.client.action;

import com.lljqiu.tools.cmpp.client.stack.MsgConnectResp;

/** 
 * ClassName: ConnectRespAction.java <br>
 * Description: <br>
 * Create by: name：liujie <br>email: liujie@lljqiu.com <br>
 * Create Time: 2018年8月31日<br>
 */
public class ConnectRespAction extends ActionFactoy {

	/* (non-Javadoc)
	 * @see com.lljqiu.tools.cmpp.client.action.ActionFactoy#exec()
	 */
	@Override
	protected void exec() throws Exception {
		System.out.println("接收到 Server 端响应"+message.toString());
		throw new RuntimeException("就想走一个异常");

	}

	/* (non-Javadoc)
	 * @see com.lljqiu.tools.cmpp.client.action.ActionFactoy#readMessage()
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected <T> T readMessage() throws Exception {
		MsgConnectResp connectResp = new MsgConnectResp();
		connectResp.setStatus(ioBuffer.getInt());
        byte[] ismg = new byte[16];
        ioBuffer.get(ismg);
        connectResp.setAuthenticatorISMG(ismg);
        connectResp.setVersion((byte)ioBuffer.getInt());
		return (T) connectResp;
	}

}
