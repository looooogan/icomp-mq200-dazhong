package com.amistrong.express.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.amistrong.express.beans.request.ChangeUser;
import com.amistrong.express.beans.request.Feedback;
import com.amistrong.express.beans.request.Login;
import com.amistrong.express.beans.request.User;
import com.amistrong.express.beans.request.UserPosition;
import com.amistrong.express.beans.request.VoteReqBean;
import com.amistrong.express.common.BaseController;
import com.amistrong.express.common.CommonClass;
import com.amistrong.express.common.MessageList;
import com.amistrong.express.common.SysConfig;
import com.amistrong.express.filter.UrlValidateFilter;

/**
 * 共通
 * 
 * @author 于鑫
 * @version 2015-4-7 16:32:49
 */
// 声明Action组件 ,controller仅作为跳转控制(控制台)
@Controller
public class ExpressController extends BaseController {
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String main(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		return "index";
	}
	/*// 注入(Spring提供的) 默认按类型装配
	@Autowired
	private Service1 server1;

	

	*//**
	 * 1 注册
	 * 
	 * @return INT 0:注册成功 1:用户已存在 2:验证码无效 3:验证码不正确
	 *         4.注册失败(地理位置、用户基本信息表、推荐人积分增添失败)
	 * 
	 * @param (String)phoneNo：电话号码 (int)verificationCode：注册码
	 *        (String)password：密码(MD5加密) (String)introducer:推荐人(电话号码，可为空)
	 *        (String)token:设备码 (String)deviceType:设备类型(1:安卓设备 2:IOS设备)
	 * 
	 *        创建User bean 并将参数作为bean的属性
	 * 
	 *//*
	@ResponseBody
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user) {
		String cJsonStr;
		try {
			int retCode = server1.register(user);
			if (retCode == 0) {
				// 注册成功 ,301
				cJsonStr = jsonResult(true,
						MessageList.INFO_SUCCESS_REGISTRATION);
			} else if (retCode == 1) {
				// 用户已存在,102
				cJsonStr = jsonResult(false, MessageList.ERR_USER_EXIST);
			} else if (retCode == 2) {
				// 验证码无效,104
				cJsonStr = jsonResult(false,
						MessageList.ERR_INVALID_AUTHENTICATION_CODE);
			} else if (retCode == 3) {
				// 验证码错误,105
				cJsonStr = jsonResult(false, MessageList.ERR_VERIFICATION);
			} else if (retCode == 5) {
				// 推荐人无效 135
				cJsonStr = jsonResult(false, MessageList.ERR_USER_PHONE);
			} else {
				// 注册失败,101
				cJsonStr = jsonResult(false,
						MessageList.ERR_REGISTRATION_FAILURE);
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 投票页面注册
	 * 
	 * @return INT 0:注册成功 1:用户已存在 2:验证码无效 3:验证码不正确
	 *         4.注册失败(地理位置、用户基本信息表、推荐人积分增添失败)
	 * 
	 * @param (String)phoneNo：电话号码 (int)verificationCode：注册码
	 *        (String)password：密码(MD5加密) (String)introducer:推荐人(电话号码，可为空)
	 *        (String)token:设备码 (String)deviceType:设备类型(1:安卓设备 2:IOS设备)
	 * 
	 *        创建User bean 并将参数作为bean的属性
	 * 
	 *//*
	@ResponseBody
	@RequestMapping(value = "/registerForVote", method = RequestMethod.POST)
	public String registerForVote(User user) {
		String cJsonStr;
		try {
			int retCode = server1.register(user);
			// 返回用户ID
			Integer userId = server1.getUserIdByPhoneNo(user.getPhoneNo());
			if (retCode == 0) {
				// 注册成功 返回用户ID,301
				cJsonStr = jsonResult(true,
						MessageList.INFO_SUCCESS_REGISTRATION, userId);
				// cJsonStr = jsonResult(true,
				// MessageList.INFO_SUCCESS_REGISTRATION);
			} else if (retCode == 1) {
				// 用户已存在,102
				cJsonStr = jsonResult(userId);
			} else if (retCode == 2) {
				// 验证码无效,104
				cJsonStr = jsonResult(false,
						MessageList.ERR_INVALID_AUTHENTICATION_CODE);
			} else if (retCode == 3) {
				// 验证码错误,105
				cJsonStr = jsonResult(false, MessageList.ERR_VERIFICATION);
			} else if (retCode == 5) {
				// 推荐人无效 135
				cJsonStr = jsonResult(false, MessageList.ERR_USER_PHONE);
			} else {
				// 注册失败,101
				cJsonStr = jsonResult(false,
						MessageList.ERR_REGISTRATION_FAILURE);
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 2 获取验证码
	 * 
	 * @return retCode>0 获取验证码成功 retCode=0 用户已经存在 retCode<0 获取验证码失败
	 * 
	 * @param (String)phoneNo：电话号码 (Integer)reqCode：请求码（0:注册 1:修改密码 ...）
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getVerificationCode", method = RequestMethod.POST)
	public String getVerificationCode(String phoneNo, Integer reqCode) {
		String cJsonStr;
		// 生成四位随机数验证码
		int code = (int) (Math.random() * 9000 + 1000);
		try {
			int retCode = server1
					.insterVerificationCode(phoneNo, code, reqCode);
			if (retCode > 0 || retCode == 0) {
				cJsonStr = jsonResult(true,
						MessageList.INFO_SUCCESS_VERIFICATION_CODE_ACQUISITION);
//			} else if (retCode == 0) {
//				// 用户已存在 , 102
//				cJsonStr = jsonResult(false, MessageList.ERR_USER_EXIST);
			} else {
				// 验证码获取失败 , 106
				cJsonStr = jsonResult(false,
						MessageList.ERR_VERIFICATION_CODE_ACQUISITION);
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 获取投票验证码
	 * 
	 * @return retCode>0 获取验证码成功 retCode=0 用户已经存在 retCode<0 获取验证码失败
	 * 
	 * @param (String)phoneNo：电话号码 (Integer)reqCode：请求码（0:注册 1:修改密码 ...）
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getVerificationCodeForVote", method = RequestMethod.POST)
	public String getVerificationCodeForVote(VoteReqBean vote) {
		String cJsonStr;
		// 生成四位随机数验证码
		int code = (int) (Math.random() * 9000 + 1000);
		try {
			Map retMap = server1.insterVerificationCodeForVote(vote, code);
			if (retMap != null && retMap.get("result") != null) {
				cJsonStr = jsonResult(false, retMap.get("message").toString(),
						retMap);
			} else {
				int retCode = Integer.parseInt(retMap.get("retCode").toString());
				if (retCode > 0) {
					cJsonStr = jsonResult(
							true,
							MessageList.INFO_SUCCESS_VERIFICATION_CODE_ACQUISITION);
					// 用户已存在 , 102
				} else if (retCode == 0) {
					cJsonStr = jsonResult(true, MessageList.ERR_USER_EXIST,retMap);
				} else {
					// 验证码获取失败 , 106
					cJsonStr = jsonResult(false,
							MessageList.ERR_VERIFICATION_CODE_ACQUISITION);
				}
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 3 登陆验证
	 * 
	 * @return userId:用户ID courierId:快递员ID 可能为null AuthenticationState:认证状态
	 *         可能为null
	 * 
	 * @param (String)phoneNo：电话号码 (String)password：密码(MD5加密) (String)token:设备码
	 *        (String)deviceType:设备类型 (double)longitude:经度 (double)latitude:纬度
	 * 
	 *        创建Login bean 并将参数作为bean的属性
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
	public String getUserInfo(Login login) {
		String cJsonStr;
		try {
			LoginState logS = server1.getUserInfo(login);
			if (logS.getCode() == 1) {
				// 用户不存在 , 103
				cJsonStr = jsonResult(false, MessageList.ERR_USER_NOT_EXIST);
			} else if (logS.getCode() == 2) {
				// 用户名或密码错误 ,108
				cJsonStr = jsonResult(false, MessageList.ERR_USER_NAME_PASSWORD);
			} else {
				cJsonStr = jsonResult(logS);
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 4 密码变更
	 * 
	 * @param (String) phoneNo verificationCode：验证码 password：新密码
	 *//*
	@ResponseBody
	@RequestMapping(value = "/passwordChange", method = RequestMethod.POST)
	public String passwordChange(ChangeUser chaUser) {
		String cJsonStr;
		try {
			int retCode = server1.passwordChange(chaUser);
			if (retCode == 0) {
				// 密码变更成功 ，316
				cJsonStr = jsonResult(true,
						MessageList.INFO_SUCCESS_CHANGE_PASSWORD);
				// 更新验证过滤器中的密码
				UrlValidateFilter.userInfo.put(chaUser.getPhoneNo(),
						chaUser.getPassword());
			} else if (retCode == 1) {
				// 验证码超时(无效),107
				cJsonStr = jsonResult(false,
						MessageList.ERR_VERIFICATION_CODE_TIMEOUT);
			} else if (retCode == 2) {
				// 验证码错误 ,105
				cJsonStr = jsonResult(false, MessageList.ERR_VERIFICATION);
			} else {
				// 用户不存在 ,103
				cJsonStr = jsonResult(false, MessageList.ERR_USER_NOT_EXIST);
			}
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 5.上传个人地理位置
	 * 
	 * @param userId
	 *            :用户ID longitude：经度 latitude：纬度
	 *//*
	@ResponseBody
	@RequestMapping(value = "/uploadPosition", method = RequestMethod.POST)
	public String uploadPosition(UserPosition userPos) {
		String cJsonStr;
		try {
			server1.uploadPosition(userPos);
			// 上传个人地理位置成功 , 317
			cJsonStr = jsonResult(true, MessageList.INFO_SUCCESS_UPLOAD);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 6 获取周围使用位置信息
	 * 
	 * @param userId
	 *            :用户ID longitude：经度 latitude：纬度
	 * 
	 * @return List<UserPosition>
	 *//*
	@ResponseBody
	@RequestMapping(value = "/getPosition", method = RequestMethod.POST)
	public String getPosition(UserPosition userPos) {
		List<UserPosition> userPoss;
		String pJsonStr;
		try {
			// 返回附近人列表
			userPoss = server1.reqUserGetPosition(userPos);
			if (userPoss.size() == 0) {
				// 数据不存在 ， 120
				pJsonStr = jsonResult(false, MessageList.ERR_DATA_NOT_EXIST);
			} else {
				// 获取成功
				pJsonStr = jsonResult(userPoss);
			}
		} catch (Exception ex) {
			// 系统错误,999
			pJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return pJsonStr;
	}

	*//**
	 * 8 反馈建议
	 * 
	 * @param Feedback
	 *            userId:用户ID content:内容
	 *//*
	@ResponseBody
	@RequestMapping(value = "/uploadFeedback", method = RequestMethod.POST)
	public String uploadFeedback(Feedback feeb) {
		String cJsonStr;
		try {
			server1.uploadFeedback(feeb);
			// 反馈成功 ，318
			cJsonStr = jsonResult(true, MessageList.INFO_SUCCESS_FEEDBACK);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}

	*//**
	 * 9 上传文件图片
	 * 
	 * @param file
	 *            ：文件数组[{}] 数组中的图片名称是已经编辑好的
	 *//*
	@ResponseBody
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String uploadFile(HttpServletRequest request) {
		String cJsonStr;
		// String strMakeThum;
		// strMakeThum = request.getParameter("makeThum");
		// 获得上传文件
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		// 获得文件名
		Iterator<String> iter = multipartRequest.getFileNames();
		String imgPath = "";
		try {
			while (iter.hasNext()) {
				String str = (String) iter.next();
				MultipartFile f = multipartRequest.getFile(str);
				CommonClass.writeFile(f.getBytes(),
						SysConfig.Value(SysConfig.UPLOAD_FILE_PATH)
								+ "/uploadImg/" + f.getOriginalFilename());
				// if ("1".equals(strMakeThum)) {
				// ByteArrayOutputStream stream = new ByteArrayOutputStream(
				// f.getBytes().length);
				// stream.write(f.getBytes());
				// String thumName = f.getOriginalFilename();
				// thumName = thumName.split("\\.")[0] + "_t."
				// + thumName.split("\\.")[1];
				// ImageEdit.createThum(stream,
				// SysConfig.Value(SysConfig.UPLOAD_FILE_PATH)
				// + thumName);
				// }
				imgPath = "/uploadImg/" + f.getOriginalFilename();
				if (null != request.getParameter("userId")
						&& !"".equals(request.getParameter("userId"))) {
					// 将头像路径更新至会员用户表
					Integer userId = Integer.valueOf(request
							.getParameter("userId"));
					server1.updateUserHeadImg(userId, imgPath);
				}
			}

			cJsonStr = jsonResult(imgPath);
			// // 上传成功 303
			// cJsonStr = jsonResult(true,
			// MessageList.INFO_SUCCESS_UPLOAD_FILE_FAILED);
		} catch (Exception e) {
			// 上传失败,110
			cJsonStr = jsonResult(false, MessageList.ERR_UPLOAD_FILE_FAILED);
		}
		return cJsonStr;
	}
	*/
	/**
	 * 安卓检查版本更新
	 * @return 版本号，下载地址
	 */
	@ResponseBody
	@RequestMapping(value = "/getVersion", method = RequestMethod.POST)
	public String getVersion() {
		String cJsonStr;
		try {
			// 反馈成功 ，318
			Map rm=new HashMap();
			rm.put("aver", SysConfig.Value(SysConfig.ANDROID_VERSION));
			rm.put("aurl", SysConfig.Value(SysConfig.ANDROID_UPURL));
			cJsonStr = jsonResult(true, MessageList.INFO_SUCCESS_FEEDBACK,rm);
		} catch (Exception ex) {
			// 系统错误,999
			cJsonStr = jsonResult(false, MessageList.SYS_ERROR);
		}
		return cJsonStr;
	}
}