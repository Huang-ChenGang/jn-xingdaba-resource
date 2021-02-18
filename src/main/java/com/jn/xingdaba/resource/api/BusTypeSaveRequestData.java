package com.jn.xingdaba.resource.api;

import com.jn.core.api.SaveReq;
import com.jn.xingdaba.resource.application.dto.BusTypeSaveRequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
public final class BusTypeSaveRequestData extends SaveReq {

    @NotBlank(message = "车型名称不能为空")
    private String busTypeName;

    @NotNull(message = "座位数不能为空")
    private Integer seatNum;

    @NotBlank(message = "品牌不能为空")
    private String brand;

    private String description;

    @NotBlank(message = "请上传车头照片")
    private String headImg;

    @NotBlank(message = "请上传侧身照片")
    private String sidewaysImg;

    @NotBlank(message = "请上传内饰照片")
    private String interiorImg;

    private String isDelete;

    public static BusTypeSaveRequestDto toDto(BusTypeSaveRequestData requestData) {
        BusTypeSaveRequestDto dto = new BusTypeSaveRequestDto();
        BeanUtils.copyProperties(requestData, dto);
        return dto;
    }
}
