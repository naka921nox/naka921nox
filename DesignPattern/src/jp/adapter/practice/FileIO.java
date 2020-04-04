package jp.adapter.practice;

import java.io.IOException;

public interface FileIO {
    public void readFromFile(String fileName) throws IOException;
    public void writeFromFile(String fileName) throws IOException;
    public void setValue(String key, String value);
    public void getValue(String key);
}