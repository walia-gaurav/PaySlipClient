package com.gauravwalia.personal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PaySlipClient {

	public static void main(String args[]) {
		PaySlipClient client = new PaySlipClient();

		System.out
				.println(client
						.getHTML("https://www.hrworkwaysindia.com/ServletController?cuen=null&cboPeriod=38%5E5%26NAG1%232015-2016%40May+2015&pwdFlag=E&jspName=PaySlipSelectPdf"));
		System.out.println("Response generated");
	}

	public String getHTML(String urlToRead) {
		URL url;
		HttpURLConnection conn;
		BufferedReader rd;
		String line;
		String result = "";
		try {
			url = new URL(urlToRead);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((line = rd.readLine()) != null) {
				result += line;
			}
			rd.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
