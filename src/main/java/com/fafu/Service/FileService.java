package com.fafu.Service;

import com.fafu.domain.files.File_Resp;
import com.fafu.domain.files.myFiles;

import java.util.List;

public interface FileService {
    public File_Resp save_file(List<myFiles> files,String path);

    public File_Resp save_bs_soil(List<myFiles> filesList);

    public File_Resp save_bs_water(List<myFiles> filesList);

    public File_Resp save_bs_forest(List<myFiles> filesList);

    public File_Resp save_bs_wetland(List<myFiles> filesList);

    public File_Resp save_soil(List<myFiles> filesList);

    public File_Resp save_water(List<myFiles> filesList);

    public File_Resp save_forest(List<myFiles> filesList);

    public File_Resp save_wetland(List<myFiles> filesList);

    public File_Resp save_notice_file(List<myFiles> filesList);

    public File_Resp save_standard_file(List<myFiles> filesList);

    public File_Resp save_industry_file(List<myFiles> filesList);

    public File_Resp save_outcome(List<myFiles> filesList);
}
