package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import common.Config;

public class Resource {
    private static final String LOG_ERROR_PATH = "log/error.log";
    private static final String SYSTEM_PATH = "config/.system.properties";
    private static final String STRUCT_PATH = "config/.struct.ini";
    private static final String STORE_NUMBER_PATH = "config/.number.properties";
    private static final String HEADER_PATH = "config/header/.header.ini";
    private static final String OBJECT_PATH = "config/object/.object.ini";
    private static final String DEFAULT_FOLDER_PATH = "config/default/folder.properties";
    private static final String DEFAULT_DATABASE_PATH = "config/default/database.properties";
    private static final String DEFAULT_QUERY_PATH = "config/default/query.properties";
    private static final String DEFAULT_VALUE_PATH = "config/default/value.properties";
    private static final String DEFAULT_LOG_INPUT_FOLDER = "log/input";
    private static final String DEFAULT_LOG_OUTPUT_FOLDER = "log/output";
    private static final String DEFAULT_LOG_PROCESS_FOLDER = "log/process";
    private static final String DEFAULT_LOG_ERROR_FOLDER = "log/error";
    private static final String WARNING = "# Please do not change content of this file, unless you know what you are doing\n" +
            "# This file is generated by the system, any manual changes will crash the system\n\n";
    public static void init() throws IOException {
        new File(LOG_ERROR_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                }
                setReadOnly();
            }
        };

        File system = new File(SYSTEM_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write((WARNING + "DELIMITER=\nLAST_USED=\n").getBytes());
                        fos.close();
                    }
                }
            }
        };
        system.setWritable(true);
        Files.setAttribute(system.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        system.setReadOnly();

        File struct = new File(STRUCT_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };
        struct.setWritable(true);
        Files.setAttribute(struct.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        struct.setReadOnly();

        File storeNumber = new File(STORE_NUMBER_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };
        storeNumber.setWritable(true);
        Files.setAttribute(storeNumber.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        storeNumber.setReadOnly();

        File header = new File(HEADER_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };
        header.setWritable(true);
        Files.setAttribute(header.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        header.setReadOnly();

        File object = new File(OBJECT_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };
        object.setWritable(true);
        Files.setAttribute(object.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
        object.setReadOnly();

        new File(DEFAULT_FOLDER_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write((WARNING +
                            String.format("INPUT=%s\nOUTPUT=%s\nERROR=%s\nPROCESS=%s",
                                DEFAULT_LOG_INPUT_FOLDER,
                                DEFAULT_LOG_OUTPUT_FOLDER,
                                DEFAULT_LOG_ERROR_FOLDER,
                                DEFAULT_LOG_PROCESS_FOLDER)).getBytes());
                        fos.close();
                    }
                }
            }
        };

        new File(DEFAULT_DATABASE_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write((WARNING + "DB_HOST=\nDB_PORT=\nDB_NAME=\nDB_USER=\nDB_PASSWORD=").getBytes());
                        fos.close();
                    }
                }
            }
        };

        new File(DEFAULT_QUERY_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };

        new File(DEFAULT_VALUE_PATH) {
            {
                if (!exists()) {
                    getParentFile().mkdirs();
                    createNewFile();
                    if (length() == 0) {
                        FileOutputStream fos = new FileOutputStream(this);
                        fos.write(WARNING.getBytes());
                        fos.close();
                    }
                }
            }
        };
    }

    public static void refresh() throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String currDate = sdf.format(new Date());
        String lastUsed = Config.getSystem("LAST_USED");
        if (lastUsed == null || lastUsed.isBlank() || !currDate.equals(lastUsed)) {
            File file = new File(STORE_NUMBER_PATH);
            file.setWritable(true);
            Files.setAttribute(file.toPath(), "dos:hidden", false, LinkOption.NOFOLLOW_LINKS);
            new FileOutputStream(file).close();
            Files.setAttribute(file.toPath(), "dos:hidden", true, LinkOption.NOFOLLOW_LINKS);
            file.setReadOnly();
            Config.setSystem(new HashMap<String, String>() {{
                put("LAST_USED", sdf.format(new Date()));
            }});
        }
    }
}