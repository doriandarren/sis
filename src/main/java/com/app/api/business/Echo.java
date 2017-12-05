package com.app.api.business;

import com.app.api.model.Message;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;



//[START echo_api_annotation]
@Api(
 name = "echo",
 version = "v1",
 namespace =
   @ApiNamespace(
     ownerDomain = "echo.business.api.app.com",
     ownerName = "echo.business.api.app.com",
     packagePath = ""
   ),
 // [START_EXCLUDE]
 issuers = {
   @ApiIssuer(
     name = "firebase",
     issuer = "https://securetoken.google.com/YOUR-PROJECT-ID",
     jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
 }
 // [END_EXCLUDE]
 )
//[END echo_api_annotation]

public class Echo {
	
	//Para entrar: http://localhost:8080/_ah/api/echo/v1/echoMessage?message=ola&n=5
	@ApiMethod(name="echoMessage", path="echoMessage", httpMethod = HttpMethod.GET)
	public Message echoMessage(Message message, @Named("n") @Nullable Integer n) {
							
		//return 	message;	
		return doEcho(message,n);
	}
	
	
	private Message doEcho(Message message, Integer n) {
		
		/*if (n != null && n >= 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; i++) {
				if (i > 0) {
					sb.append(" ");
				}
				sb.append(message.getMessage());
			}
			message.setMessage(sb.toString());
		}*/		
		return message;
	}
	
}
