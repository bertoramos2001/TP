package es.ucm.tp1.supercars.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.ucm.tp1.supercars.control.Level;
import es.ucm.tp1.supercars.control.exceptions.CommandExecuteException;
import es.ucm.tp1.supercars.control.exceptions.InputOutputRecordException;

public class Record {
	private final String RECORD_NAME = "record.txt";
	private Level level;
	private double bestTimeInMs;
	private final String FAIL_RECORD_MSG = "Failed to open record file";
	private final String FAIL_CURRENT_RECORD_MSG = "Record in milliseconds must be an integer";
	
	public Record(Level level) throws InputOutputRecordException {
		this.level = level;
		
		checkRecord();
	}
	
	private void checkRecord() throws InputOutputRecordException {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(RECORD_NAME))) {
			String line = reader.readLine();
			String levelName = level.name();
			boolean found = false;
			double currentRecordInMs;
			
			while(line != null && !found) {
				String[] parts = line.split(":");
				
				if (parts[0].equalsIgnoreCase(levelName)) {
					found = true;
					currentRecordInMs = Double.parseDouble(parts[1]);
					bestTimeInMs = currentRecordInMs;
				}
				line = reader.readLine();
			}
			
			if (!found) {
				bestTimeInMs = Long.MAX_VALUE;
				String.format("Creating default record for level '%s'", level.name().toUpperCase());
				setNewRecord(bestTimeInMs);
			}
			
		} catch (IOException e) {
			throw new InputOutputRecordException(String.format("[ERROR]: %s", FAIL_RECORD_MSG));
		} catch (NumberFormatException e) {
			//throw new CommandExecuteException(String.format("[ERROR]: %s", FAIL_CURRENT_RECORD_MSG));
		}
	}
	
	public void setNewRecord(double newRecord) {
		StringBuilder sb = new StringBuilder();
		bestTimeInMs = newRecord;
		
		sb.append(String.format("%s:%d", level.name().toUpperCase(), bestTimeInMs));
		
		try (BufferedReader reader = new BufferedReader(new FileReader(RECORD_NAME))) {
			String line = reader.readLine();
			
			while (line != null) {
				String[] parts = line.split(":");
				
				if (!level.name().equalsIgnoreCase(parts[0])) {
					sb.append(line + "\n");
				}
				line = reader.readLine();
			}
			
		} catch(IOException e) {
			
		}
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(RECORD_NAME))) {
			writer.append(sb.toString());
		} catch (IOException e) {
			
		}
	}
	
	public double getRecord() {
		return bestTimeInMs;
	}
}
