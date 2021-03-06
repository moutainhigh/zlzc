package com.zlzc.modules.commodity.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author LSR
 * @email zlzc@example.com
 * @date 2019-12-09 14:50:18
 */
@Data
@TableName("zlzc_commodity_pic")
@Accessors(chain = true)
public class CommodityPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图片ID
	 */
	@ApiModelProperty(name = "picId", value = "图片ID", example = "图片ID")
	@TableId
	private Long picId;
	/**
	 * 相册ID
	 */
	@ApiModelProperty(name = "albumId", value = "相册ID", example = "相册ID")
	private Long albumId;
	/**
	 * 图片URL
	 */
	@ApiModelProperty(name = "picUrl", value = "图片URL", example = "图片URL")
	private String picUrl;
	/**
	 * 图片描述
	 */
	@ApiModelProperty(name = "picUrl", value = "图片描述", example = "图片描述")
	private String picDesc;
	/**
	 * 图片名称
	 */
	@ApiModelProperty(name = "picName", value = "图片名称", example = "图片名称")
	private String picName;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(name = "createTime", value = "创建时间", example = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(name = "updateTime", value = "更新时间", example = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/**
	 * 操作人
	 */
	@ApiModelProperty(name = "operator", value = "操作人", example = "操作人")
	private String operator;

}
