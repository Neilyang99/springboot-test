/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.enilu.flash.utils;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {


	private static final Object LOCK = new Object();

	private static final Map<String, ThreadLocal<SimpleDateFormat>> POOL = new HashMap<String, ThreadLocal<SimpleDateFormat>>();
	/**
	 * 获取YYYY格式
	 *
	 * @return
	 */
	public static String getYear() {
		return formatDate(new Date(), "yyyy");
	}

	/**
	 * 获取YYYY格式
	 *
	 * @return
	 */
	public static String getYear(Date date) {
		return formatDate(date, "yyyy");
	}

	/**
	 * 获取YYYY-MM-DD格式
	 *
	 * @return
	 */
	public static String getDay() {
		return formatDate(new Date(), "yyyy-MM-dd");
	}

	/**
	 * 获取YYYY-MM-DD格式
	 *
	 * @return
	 */
	public static String getDay(Date date) {
		return formatDate(date, "yyyy-MM-dd");
	}

	/**
	 * 获取YYYYMMDD格式
	 *
	 * @return
	 */
	public static String getDays() {
		return formatDate(new Date(), "yyyyMMdd");
	}

	/**
	 * 获取YYYYMMDD格式
	 *
	 * @return
	 */
	public static String getDays(Date date) {
		return formatDate(date, "yyyyMMdd");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 *
	 * @return
	 */
	public static String getTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss.SSS格式
	 *
	 * @return
	 */
	public static String getMsTime() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss.SSS");
	}

	/**
	 * 获取YYYYMMDDHHmmss格式
	 *
	 * @return
	 */
	public static String getAllTime() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}

	/**
	 * 获取YYYY-MM-DD HH:mm:ss格式
	 *
	 * @return
	 */
	public static String getTime(Date date) {
		return formatDate(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static String formatDate(Date date, String pattern) {
		String formatDate = null;
		if (StringUtil.isNotEmpty(pattern)) {
			formatDate = DateFormatUtils.format(date, pattern);
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}

	/**
	 * @Title: compareDate
	 * @Description:(日期比较，如果s>=e 返回true 否则返回false)
	 * @param s
	 * @param e
	 * @return boolean
	 * @throws
	 * @author luguosui
	 */
	public static boolean compareDate(String s, String e) {
		if (parseDate(s) == null || parseDate(e) == null) {
			return false;
		}
		return parseDate(s).getTime() >= parseDate(e).getTime();
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date parseDate(String date) {
		return parse(date,"yyyy-MM-dd");
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date parseTime(String date) {
		return parse(date,"yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static Date parse(String date, String pattern) {
		if (date != null) {
			if (pattern == null || "".equals(pattern)) {
				return null;
			}
			DateFormat format = getDFormat(pattern);
			try {
				return format.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public static SimpleDateFormat getDFormat(String pattern) {
		ThreadLocal<SimpleDateFormat> tl = POOL.get(pattern);
		if (tl == null) {
			synchronized (LOCK) {
				tl = POOL.get(pattern);
				if (tl == null) {
					final String p = pattern;
					tl = new ThreadLocal<SimpleDateFormat>() {
						@Override
						protected synchronized SimpleDateFormat initialValue() {
							return new SimpleDateFormat(p);
						}
					};
					POOL.put(p, tl);
				}
			}
		}
		return tl.get();
	}

	/**
	 * 格式化日期
	 *
	 * @return
	 */
	public static String format(Date date, String pattern) {
		return DateFormatUtils.format(date, pattern);
	}

	/**
	 * 把日期转换为Timestamp
	 *
	 * @param date
	 * @return
	 */
	public static Timestamp format(Date date) {
		return new Timestamp(date.getTime());
	}

	/**
	 * 校验日期是否合法
	 *
	 * @return
	 */
	public static boolean isValidDate(String s) {
		return parse(s, "yyyy-MM-dd HH:mm:ss") != null;
	}

	/**
	 * 校验日期是否合法
	 *
	 * @return
	 */
	public static boolean isValidDate(String s, String pattern) {
        return parse(s, pattern) != null;
	}

	public static int getDiffYear(String startTime, String endTime) {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		try {
			int years = (int) (((fmt.parse(endTime).getTime() - fmt.parse(
					startTime).getTime()) / (1000 * 60 * 60 * 24)) / 365);
			return years;
		} catch (Exception e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return 0;
		}
	}

	/**
	 * <li>功能描述：时间相减得到天数
	 *
	 * @param beginDateStr
	 * @param endDateStr
	 * @return long
	 * @author Administrator
	 */
	public static long getDaySub(String beginDateStr, String endDateStr) {
		long day = 0;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd");
		Date beginDate = null;
		Date endDate = null;

		try {
			beginDate = format.parse(beginDateStr);
			endDate = format.parse(endDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		day = (endDate.getTime() - beginDate.getTime()) / (24 * 60 * 60 * 1000);
		// System.out.println("相隔的天数="+day);

		return day;
	}

	/**
	 * 得到n天之后的日期
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayDate(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdfd.format(date);

		return dateStr;
	}

	/**
	 * 得到n天之后是周几
	 *
	 * @param days
	 * @return
	 */
	public static String getAfterDayWeek(String days) {
		int daysInt = Integer.parseInt(days);

		Calendar canlendar = Calendar.getInstance(); // java.util包
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		Date date = canlendar.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("E");
		String dateStr = sdf.format(date);

		return dateStr;
	}
	
	/**
	 * YWG
	 * 基準日加減幾天
	 * @param date 基準日
	 * @param days 加/減天數
	 * @return Date
	 */
	public static Date getDateAfterDays(Date date, String days) {
		int daysInt = Integer.parseInt(days);
		
		Calendar canlendar = Calendar.getInstance(); 
		canlendar.setTime(date);
		canlendar.add(Calendar.DATE, daysInt); // 日期减 如果不够减会将月变动
		

		return canlendar.getTime();
	}
	
	/**
	 * YWG
	 * get the first date(Monday) in this week
	 * @param date
	 * @return
	 */
	public static Date getThisWeekMonday(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 獲得當前日期是一個星期的第幾天
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_MONTH, -1);
		}
		// 設定一個星期的第一天，按中國的習慣一個星期的第一天是星期一
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		// 獲得當前日期是一個星期的第幾天
		int day = cal.get(Calendar.DAY_OF_WEEK);
		// 根據日曆的規則，給當前日期減去星期幾與一個星期第一天的差值
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
		return cal.getTime();
	}


	public static void main(String[] args) {
		//System.out.println(getTime(new Date()));
		//System.out.println(getAfterDayWeek("3"));
		try {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf.parse("20210706");
		System.out.println("本週一:" + sdf.format(getThisWeekMonday(date)));
		System.out.println("本週日:" + sdf.format(getDateAfterDays(date,"6")));
		
		}catch(Exception e) {
			
		}
	}

}
