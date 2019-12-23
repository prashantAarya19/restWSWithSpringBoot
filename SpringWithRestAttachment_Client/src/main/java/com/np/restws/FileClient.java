package com.np.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {
		WebClient client = WebClient.create("http://localhost:8080/restattachment/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachment;fiename=Upload.jpg");
		Attachment attachment = new Attachment("root",
				new FileInputStream(new File("C:\\Users\\kpras\\OneDrive\\Desktop\\Files\\1.jpg")), cd);
		client.post(attachment);
	}

}
