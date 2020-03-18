package link.larva;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xce
 * @date 2020/3/18  15:34
 */
@Slf4j
public class MysqlUtils {


  /**
   * 生成批量删除数据库列SQL语句
   *
   * @param tables 数据库表明数组
   * @param column 列名
   * @return SQL语句
   */
  public static String generateAlterColumn(String[] tables, String column) {
    StringBuilder sql = new StringBuilder();
    for (String s : tables) {
      sql.append("ALTER TABLE ").append(s).append(" DROP COLUMN ").append(column).append(";\r\n");
    }
    return sql.toString();
  }

  /**
   * 生成批量创建数据库列SQL语句
   *
   * @param tables   数据库表明数组
   * @param column   列名
   * @param dataType 数据类型
   * @param remark   备注
   * @return SQL语句
   */
  public static String generateAlterNewColumn(String[] tables, String column, String dataType, String remark) {
    StringBuilder sql = new StringBuilder();
    for (String s : tables) {
      sql.append("ALTER TABLE ").append(s).append(" ADD COLUMN ").append(column).append(" ").append(dataType)
          .append(" COMMENT '").append(remark).append("';").append("\r\n");
    }
    return sql.toString();
  }

  public static void main(String[] args) {
    String[] strings = new String[]{"sys_role", "sys_role_menu", "sys_role_permission", "sys_user", "sys_user_role"};
    System.out.println(generateAlterNewColumn(strings, "update_time", "BIGINT", "更新时间"));
    log.error(generateAlterNewColumn(strings, "update_time", "BIGINT", "更新时间"));
  }

}
