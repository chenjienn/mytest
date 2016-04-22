package mytest.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class SSH2Demo {
	private static final Logger LOG = LoggerFactory.getLogger(SSH2Demo.class);
	public static void main(String[] args) {
		LOG.info("start ssh2 connection");
		boolean isConn = false;
		Connection conn = new Connection("172.18.63.74", 22);
		Session session;
		try {
			conn.connect(null, 2000, 2000);
			isConn = conn.authenticateWithPassword("uchatredis", "uchatredis");
			session = conn.openSession();
			session.execCommand("echo cons | nc 172.18.63.74 2181");
			InputStream getstdout = session.getStdout();
			InputStream getstderr = session.getStderr();
			InputStream stdout = new StreamGobbler(getstdout);
			InputStream stderr = new StreamGobbler(getstderr);
			BufferedReader stdoutReader = new BufferedReader(new InputStreamReader(stdout));
			BufferedReader stderrReader = new BufferedReader(new InputStreamReader(stderr));
			while(true){
				String line = stdoutReader.readLine();
				if(line == null){
					break;
				}
				System.out.println(line);
			}
			while(true){
				String line = stderrReader.readLine();
				if(line == null){
					break;
				}
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
