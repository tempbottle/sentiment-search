package zx.soft.sent.web.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zx.soft.sent.web.server.FirstPageServer;
import zx.soft.sent.web.server.HarmfulInfoServer;
import zx.soft.sent.web.server.InternetTaskServer;
import zx.soft.sent.web.server.NicknameGroupServer;
import zx.soft.sent.web.server.PullRecordServer;
import zx.soft.sent.web.server.SentimentIndexServer;
import zx.soft.sent.web.server.SentimentSearchServer;
import zx.soft.sent.web.server.SiteServer;
import zx.soft.sent.web.server.SpecialServer;
import zx.soft.sent.web.server.SpecialSpeedServer;

/**
 * 驱动类
 *
 * @author wanggang
 *
 */
public class SentWebDriver {

	private static Logger logger = LoggerFactory.getLogger(SentWebDriver.class);

	/**
	 * 主函数，需要修改，启动接口后，又关闭了
	 */
	public static void main(String[] args) {

		if (args.length == 0) {
			System.err.println("Usage: Input <class-name>, eg: \n" + //
					"`sentimentIndexServer` 索引接口服务\n" + //
					"`sentimentSearchServer` 搜索接口服务\n" + //
					"`pullRecordServer` 数据库查询接口服务\n" + //
					"`nicknameGroupServer` 根据nickname统计查询\n" + //
					"`siteServer` 站点数据存储到Redis服务\n" + //
					"`specialServer` OA专题信息CRUD服务\n" + //
					"`specialSpeedServer` OA专题信息CRUD服务Speed\n" + //
					"`firstPageServer` OA首页信息缓存服务\n" + //
					"`harmfulInfoServer` OA有害信息缓存服务\n" + //
					"`internetTaskServer` 全网搜索任务联合接口服务");
			System.exit(-1);
		}
		String[] leftArgs = new String[args.length - 1];
		System.arraycopy(args, 1, leftArgs, 0, leftArgs.length);

		switch (args[0]) {
		// 放弃
		case "sentimentIndexServer":
			logger.info("索引接口服务");
			SentimentIndexServer.main(leftArgs);
			break;
		// 运行在hefei01和hefei03两台机器上
		case "sentimentSearchServer":
			logger.info("搜索接口服务");
			SentimentSearchServer.main(leftArgs);
			break;
		// 运行在hefei01机器上
		case "pullRecordServer":
			logger.info("数据库查询接口服务");
			PullRecordServer.main(leftArgs);
			break;
		// 运行在hefei02机器上
		case "nicknameGroupServer":
			logger.info("根据nickname统计查询");
			NicknameGroupServer.main(leftArgs);
			break;
		// 运行在hefei01机器上
		case "siteServer":
			logger.info("站点数据存储到Redis服务");
			SiteServer.main(leftArgs);
			break;
		// 运行在hefei07机器上
		case "specialServer":
			logger.info("OA专题信息CRUD服务");
			// 准备放弃
			SpecialServer.main(leftArgs);
			break;
		// 运行在hefei03机器上
		case "specialSpeedServer":
			logger.info("OA专题信息CRUD服务Speed");
			SpecialSpeedServer.main(leftArgs);
			break;
		// 运行在hefei07机器上
		case "firstPageServer":
			logger.info("OA首页信息缓存服务");
			FirstPageServer.main(leftArgs);
			break;
		// 运行在hefei07机器上
		case "harmfulInfoServer":
			logger.info("OA有害信息缓存服务");
			HarmfulInfoServer.main(leftArgs);
			break;
		// 运行在hefei05机器上
		case "internetTaskServer":
			logger.info("全网搜索任务联合接口服务");
			InternetTaskServer.main(leftArgs);
			break;
		default:
			return;
		}

		//		int exitCode = -1;
		//		ProgramDriver pgd = new ProgramDriver();
		//		try {
		//			pgd.addClass("sentimentIndexServer", SentimentIndexServer.class, "索引接口");
		//			pgd.addClass("sentimentSearchServer", SentimentSearchServer.class, "搜索接口");
		//			pgd.addClass("siteServer", SiteServer.class, "写入站点数据组合到Redis中");
		//			pgd.addClass("specialServer", SpecialServer.class, "OA专题查询缓存服务，专题信息写入和删除");
		//			pgd.addClass("firstPageServer", FirstPageServer.class, "OA首页信息缓存服务");
		//			pgd.addClass("harmfulInfoServer", HarmfulInfoServer.class, "OA有害信息查询");
		//			pgd.driver(args);
		//			// Success
		//			exitCode = 0;
		//		} catch (Throwable e) {
		//			throw new RuntimeException(e);
		//		}
		//		System.exit(exitCode);

	}
}
