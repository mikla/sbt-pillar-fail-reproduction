name := "sbt pillar migration fail reproduce"

version := "1.0"

scalaVersion := "2.11.8"

import io.ino.sbtpillar.Plugin.PillarKeys.{pillarConfigKey, _}

pillarSettings ++ Seq(
  pillarConfigFile := file("conf/application.conf"),
  pillarConfigKey := "cassandra.url",
  pillarReplicationStrategyConfigKey := "cassandra.replicationStrategy",
  pillarReplicationFactorConfigKey := "cassandra.replicationFactor",
  pillarDefaultConsistencyLevelConfigKey := "cassandra.defaultConsistencyLevel",
  pillarMigrationsDir := file("conf/migrations"))