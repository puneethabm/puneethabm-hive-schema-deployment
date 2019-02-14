package com.puneethabm.hive.schema.utils

import java.sql.{Connection, DriverManager}

object HiveResources {
	/**
	  * Get Hive Connection
	  *
	  * @param hostName            HostName
	  * @param userName            Username
	  * @param password            Password
	  * @param defaultDatabaseName Default database name to use for establishing the connection
	  * @return Hive Connection Object
	  */
	def getHiveConnection(hostName: String, userName: String, password: String, defaultDatabaseName: String = "default"): Connection = {
		val port: Int = 10000
		val url: String = s"jdbc:hive2://${hostName}:${port}/${defaultDatabaseName}"
		val driver: String = "org.apache.hive.jdbc.HiveDriver"

		Class.forName(driver)

		val connection: Connection = DriverManager.getConnection(url, userName, password)
		connection
	}
}