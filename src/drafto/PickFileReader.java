/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package drafto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author cbachich
 */
public class PickFileReader {
 
  private int _rows;
  private int _columns;
  private BufferedReader _reader = null;
  private File _file = null;
  private String _error = "";
  private Object[][] _table = null;
  
  public PickFileReader(int rows, int columns) {
    _rows = rows;
    _columns = columns;
  }
  
  public boolean Read(File file) {
    _file = file;
    try {
      _reader = new BufferedReader(new FileReader(_file));
      return createDataTable();
    }
    catch(FileNotFoundException ex) {
      _error = "Could not find: " + _file.getName();
      return false;
    }

    finally {
      try {
        if (_reader != null) {
            _reader.close();
        }
        return true;
      } catch (IOException e) {
        _error = "Error while closing file: " + _file.getName();
        return false;
      }
    }
  }
  
  public Object[][] Table() {
    return _table;
  }
  
  public String Error() {
    return _error;
  }
  
  private boolean createDataTable() {
    try {
      String text;
      ArrayList<String[]> teams = new ArrayList();
      while ((text = _reader.readLine()) != null) {
        teams.add(text.split(","));
      }
      _table = new Object[_rows][_columns];
      for (int i = 0; i < teams.size(); i++) {
        String[] parts = teams.get(i);
        _table[i][0] = parts[0];
        for (int x = 1; x < 6; x++) {
          _table[i][x] = Integer.parseInt(parts[x]);
        }
      }
    }
    catch(IOException ex) {
      _error = "Error while reading file: " + _file;
      return false;
    }
    
    return true;
  }
}
