package interfaceGrafica;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/* Classe utilizada na seleção de arquivos a abrir ou salvar */
public class FileChooser implements java.lang.AutoCloseable {
	FileChooser(){
		
	}	
	private static final String LAST_USED_FOLDER = "Last_Used_Folder";
	
	private static File selectedOpenFile=null;
	
	private static File selectedSaveFile=null;
	
	private static String filename ="";
	
	/**
	 * @return the filename
	 */
	public static String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public static void setFilename(String filename) {
		FileChooser.filename = filename;
	}

	public void openFile() throws IOException { 
		Preferences prefs = Preferences.userRoot().node(getClass().getName());
		JFileChooser jfc = new JFileChooser(prefs.get(LAST_USED_FOLDER,
			    new File(".").getAbsolutePath()));
		jfc.setDialogTitle("Select the file *.py ou *.pyw");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.py or *.pyw", "py", "pyw");
		jfc.addChoosableFileFilter(filter);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    setSelectedOpenFile(jfc.getSelectedFile());
		    prefs.put(LAST_USED_FOLDER, jfc.getSelectedFile().getParent());
		}		
	}
	
	public void saveFile() throws IOException { 
		Preferences prefs = Preferences.userRoot().node(getClass().getName());
		JFileChooser jfc = new JFileChooser(prefs.get(LAST_USED_FOLDER,
			    new File(".").getAbsolutePath()));
		jfc.setDialogTitle("Select the file *.py ou *.pyw");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("*.py or *.pyw", "py", "pyw");		
		jfc.addChoosableFileFilter(filter);
		jfc.setFileFilter(filter);
		int returnVal = jfc.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filename = jfc.getSelectedFile().toString();
			if (!(filename.endsWith(".pyw") || filename.endsWith(".py"))) {
		        filename += ".pyw";
		        
			}
		    setSelectedSaveFile(new File(filename));
		    prefs.put(LAST_USED_FOLDER, jfc.getSelectedFile().getParent());
		}		
	}

	/**
	 * @return the selectedOpenFile
	 */
	public static File getSelectedOpenFile() {
		return selectedOpenFile;
	}

	/**
	 * @param selectedOpenFile the selectedOpenFile to set
	 */
	public static void setSelectedOpenFile(File selectedOpenFile) {
		FileChooser.selectedOpenFile = selectedOpenFile;
	}

	/**
	 * @return the selectedSaveFile
	 */
	public static File getSelectedSaveFile() {
		return selectedSaveFile;
	}

	/**
	 * @param selectedSaveFile the selectedSaveFile to set
	 */
	public static void setSelectedSaveFile(File selectedSaveFile) {
		FileChooser.selectedSaveFile = selectedSaveFile;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub		
	}
}
