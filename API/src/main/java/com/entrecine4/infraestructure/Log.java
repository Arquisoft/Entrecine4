package com.entrecine4.infraestructure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.entrecine4.SendEmail;

public class Log 
{
	private static int errCounter = 0;
	private static Logger logger = Logger.getLogger("API Logger");

	public static void log(String message)
	{
		logger.error(message);
		
		if (++errCounter == 20) 
		{
			errCounter = 0;
			SendEmail.sendNewMail("entrecine4as@gmail.com",
					"src/main/resources/log.out");
			cleanLog();
		}
	}

	private static void cleanLog() 
	{
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(
					"src/main/resources/log.out"));
			writer.write(""); //Overwrites whatever is in the log
		} catch (IOException e) {
			e.printStackTrace();
		} finally 
		{
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}