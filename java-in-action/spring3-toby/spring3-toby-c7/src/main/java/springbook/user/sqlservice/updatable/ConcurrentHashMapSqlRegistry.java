package springbook.user.sqlservice.updatable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import springbook.user.sqlservice.SqlNotFoundException;
import springbook.user.sqlservice.SqlUpdateFailureException;
import springbook.user.sqlservice.UpdatableSqlRegistry;

public class ConcurrentHashMapSqlRegistry implements UpdatableSqlRegistry {
	private final Map<String, String> sqlMap = new ConcurrentHashMap<String, String>();

	@Override
	public String findSql(String key) throws SqlNotFoundException {
		String sql = sqlMap.get(key);
		if (sql == null)
			throw new SqlNotFoundException(key + "를 이용해서 sql을 찾을 수 없습니다.");
		else
			return sql;
	}

	@Override
	public void registerSql(String key, String sql) {
		sqlMap.put(key, sql);
	}


	@Override
	public void updateSql(String key, String sql) throws SqlUpdateFailureException {
		if (sqlMap.get(key) == null) {
			throw new SqlUpdateFailureException(key + "に　当該するSQLが見つかりません");
		}
		sqlMap.put(key, sql);
	}

	@Override
	public void updateSql(Map<String, String> sqlmap) throws SqlUpdateFailureException {
		for (Map.Entry<String, String> entry : sqlmap.entrySet()) {
			updateSql(entry.getKey(), entry.getValue());
		}
	}

}
