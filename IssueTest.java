package testlogging;

import java.util.concurrent.ExecutionException;

import com.google.api.gax.paging.Page;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Logging.EntryListOption;

public class IssueTest {
	public static void main(String... args) throws Exception,ExecutionException {

		// Instantiates a client
		LoggingOptions options = LoggingOptions.getDefaultInstance();

		String logName = "projects/positive-wonder-223309/logs/";			 // LogName

		try (Logging logging = options.getService()) {
	
			String logFilter = logName;

			// List all log entries
			
			 Page<LogEntry> entries = logging.listLogEntries(
			          EntryListOption.filter(logFilter));
			      do {
			        for (LogEntry logEntry : entries.iterateAll()) {
			        		if (entries.hasNextPage()) {
							System.out.println(logEntry);
							System.out.println(entries.hasNextPage());
							System.out.println(entries.getNextPage());
						}
			        }
			        
			      } while (entries != null);

			    }
			    // [END listlogs]
			  }
			}

		
