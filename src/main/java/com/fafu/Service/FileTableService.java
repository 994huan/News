package com.fafu.Service;

import com.fafu.domain.Some_Data_Resp;

public interface FileTableService {
    public Some_Data_Resp find_file_table(Integer page, Integer rows, String query, String path);
}
