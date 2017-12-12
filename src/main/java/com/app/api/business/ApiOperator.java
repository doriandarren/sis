package com.app.api.business;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiNamespace;



//[START echo_api_annotation]
@Api(
name = "apioperator",
version = "v1",
namespace =
 @ApiNamespace(
   ownerDomain = "apioperator.business.api.app.com",
   ownerName = "apioperator.business.api.app.com",
   packagePath = ""
 ),
// [START_EXCLUDE]
issuers = {
 @ApiIssuer(
   name = "firebase",
   issuer = "https://securetoken.google.com/my-api-new",
   jwksUri = "https://www.googleapis.com/robot/v1/metadata/x509/securetoken@system.gserviceaccount.com")
}
// [END_EXCLUDE]
)
//[END echo_api_annotation]
public class ApiOperator {

	
	
	
}
