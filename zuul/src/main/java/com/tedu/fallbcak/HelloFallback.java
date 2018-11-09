package com.tedu.fallbcak;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class HelloFallback implements ZuulFallbackProvider{

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse()
	    {
		   @Override
		   public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				return new ByteArrayInputStream(("fallback"+HelloFallback.this.getRoute()).getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				// TODO Auto-generated method stub
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.value();
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
	    };
	}

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		return "provider-user";
	}

}
