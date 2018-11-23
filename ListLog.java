package testlogging;
import java.util.concurrent.RejectedExecutionException;
import com.google.api.gax.paging.Page;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import com.google.cloud.logging.Logging.EntryListOption;

public class ListLog {

	public static void main(String[] args) throws Exception, RejectedExecutionException {

		// Instantiates a client
		LoggingOptions options = LoggingOptions.getDefaultInstance();

		String logName = "projects/issues-223411/logs/my-test-log1"; // LogName

		try (Logging logging = options.getService()) {
			String logFilter = logName;
			// List all log entries
			Page<LogEntry> entries = logging.listLogEntries(EntryListOption.filter(logFilter));

			do {
				for (LogEntry logEntry : entries.iterateAll()) {
					/*'If' condition works when there is more than one page and hasNextPage return
					 true. */
					if (entries.hasNextPage()) {
						entries = entries.getNextPage();
					}
					// You can print LogEntry Here.
				}
				// Terminate codition when there is only one page.
				break;
			} while (entries != null);
			// [END of class]
		}
	}
}
