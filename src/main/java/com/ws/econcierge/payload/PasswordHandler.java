package com.ws.econcierge.payload;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

@com.ws.econcierge.payload.Callback
public class PasswordHandler implements CallbackHandler
{

	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
	{
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		if (pc.getIdentifier().equals("euler"))
		{
			pc.setPassword("gagm2221");
		}
		
	}

}
