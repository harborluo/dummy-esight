package com.fd.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	@Value("${fusionDirector.json-dir}")
	private String jsonDir;
	
	public String readJson(String fileName){
		final StringBuilder out = new StringBuilder();
		try {
			InputStream inputStream  = resourceLoader.getResource(jsonDir + fileName).getInputStream();
			final int bufferSize = 1024;
			final char[] buffer = new char[bufferSize];
			
			Reader in = new InputStreamReader(inputStream, "UTF-8");
			for (; ; ) {
				int rsz = in.read(buffer, 0, buffer.length);
				if (rsz < 0)
					break;
				out.append(buffer, 0, rsz);
			}
			return out.toString();
			
			
		}catch(IOException o){
			out.append("{error\":\"file '"+jsonDir + fileName+"' not found!\"}");
		}
		return out.toString();
	}
}
