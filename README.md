Minimal sbt-pillar migration fail reproduction project.

To reproduce run:

`sbt`

`createKeyspace`

`migrate`

I'm getting following error: 

```
> last
[info] Reading config from /Users/mikla/projects/sbt-pillar-fail-reproduce/conf/application.conf
[info] Migrating keyspace my_keyspace at 127.0.0.1:9042 using migrations in [conf/migrations] with consistency ALL
[error] An error occurred while performing task: com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:58)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:24)
        at com.datastax.driver.core.DriverThrowables.propagateCause(DriverThrowables.java:37)
        at com.datastax.driver.core.DefaultResultSetFuture.getUninterruptibly(DefaultResultSetFuture.java:245)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:63)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:39)
        at de.kaufhof.pillar.Migration$class.executeUpStatement(Migration.scala:38)
        at de.kaufhof.pillar.ReversibleMigration.executeUpStatement(Migration.scala:75)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at scala.collection.immutable.List.foreach(List.scala:318)
        at de.kaufhof.pillar.CassandraMigrator.migrate(CassandraMigrator.scala:12)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:194)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:187)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$Pillar$.withSession(Plugin.scala:158)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:59)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$Pillar$.withCassandraUrl(Plugin.scala:131)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:51)
        at scala.Function1$$anonfun$compose$1.apply(Function1.scala:47)
        at sbt.$tilde$greater$$anonfun$$u2219$1.apply(TypeFunctions.scala:40)
        at sbt.std.Transform$$anon$4.work(System.scala:63)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
        at sbt.Execute.work(Execute.scala:237)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
        at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
Caused by: com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.Responses$Error.asException(Responses.java:132)
        at com.datastax.driver.core.DefaultResultSetFuture.onSet(DefaultResultSetFuture.java:179)
        at com.datastax.driver.core.RequestHandler.setFinalResult(RequestHandler.java:184)
        at com.datastax.driver.core.RequestHandler.access$2500(RequestHandler.java:43)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.setFinalResult(RequestHandler.java:798)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.onSet(RequestHandler.java:617)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:1005)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:928)
        at io.netty.channel.SimpleChannelInboundHandler.channelRead(SimpleChannelInboundHandler.java:105)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.timeout.IdleStateHandler.channelRead(IdleStateHandler.java:266)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:276)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:263)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:846)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:131)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:511)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
        at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:112)
        at java.lang.Thread.run(Thread.java:745)
[error] An error occurred while performing task: com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:58)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:24)
        at com.datastax.driver.core.DriverThrowables.propagateCause(DriverThrowables.java:37)
        at com.datastax.driver.core.DefaultResultSetFuture.getUninterruptibly(DefaultResultSetFuture.java:245)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:63)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:39)
        at de.kaufhof.pillar.Migration$class.executeUpStatement(Migration.scala:38)
        at de.kaufhof.pillar.ReversibleMigration.executeUpStatement(Migration.scala:75)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at scala.collection.immutable.List.foreach(List.scala:318)
        at de.kaufhof.pillar.CassandraMigrator.migrate(CassandraMigrator.scala:12)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:194)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:187)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$Pillar$.withSession(Plugin.scala:158)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:59)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$Pillar$.withCassandraUrl(Plugin.scala:131)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:51)
        at scala.Function1$$anonfun$compose$1.apply(Function1.scala:47)
        at sbt.$tilde$greater$$anonfun$$u2219$1.apply(TypeFunctions.scala:40)
        at sbt.std.Transform$$anon$4.work(System.scala:63)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
        at sbt.Execute.work(Execute.scala:237)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
        at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
Caused by: com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.Responses$Error.asException(Responses.java:132)
        at com.datastax.driver.core.DefaultResultSetFuture.onSet(DefaultResultSetFuture.java:179)
        at com.datastax.driver.core.RequestHandler.setFinalResult(RequestHandler.java:184)
        at com.datastax.driver.core.RequestHandler.access$2500(RequestHandler.java:43)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.setFinalResult(RequestHandler.java:798)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.onSet(RequestHandler.java:617)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:1005)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:928)
        at io.netty.channel.SimpleChannelInboundHandler.channelRead(SimpleChannelInboundHandler.java:105)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.timeout.IdleStateHandler.channelRead(IdleStateHandler.java:266)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:276)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:263)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:846)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:131)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:511)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
        at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:112)
        at java.lang.Thread.run(Thread.java:745)
com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:58)
        at com.datastax.driver.core.exceptions.SyntaxError.copy(SyntaxError.java:24)
        at com.datastax.driver.core.DriverThrowables.propagateCause(DriverThrowables.java:37)
        at com.datastax.driver.core.DefaultResultSetFuture.getUninterruptibly(DefaultResultSetFuture.java:245)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:63)
        at com.datastax.driver.core.AbstractSession.execute(AbstractSession.java:39)
        at de.kaufhof.pillar.Migration$class.executeUpStatement(Migration.scala:38)
        at de.kaufhof.pillar.ReversibleMigration.executeUpStatement(Migration.scala:75)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at de.kaufhof.pillar.CassandraMigrator$$anonfun$migrate$2.apply(CassandraMigrator.scala:12)
        at scala.collection.immutable.List.foreach(List.scala:318)
        at de.kaufhof.pillar.CassandraMigrator.migrate(CassandraMigrator.scala:12)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:194)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:187)
        at io.ino.sbtpillar.Plugin$Pillar$$anonfun$migrate$1.apply(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$Pillar$.withSession(Plugin.scala:158)
        at io.ino.sbtpillar.Plugin$Pillar$.migrate(Plugin.scala:186)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:59)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3$$anonfun$apply$5.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$Pillar$.withCassandraUrl(Plugin.scala:131)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:55)
        at io.ino.sbtpillar.Plugin$$anonfun$taskSettings$3.apply(Plugin.scala:51)
        at scala.Function1$$anonfun$compose$1.apply(Function1.scala:47)
        at sbt.$tilde$greater$$anonfun$$u2219$1.apply(TypeFunctions.scala:40)
        at sbt.std.Transform$$anon$4.work(System.scala:63)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1$$anonfun$apply$1.apply(Execute.scala:228)
        at sbt.ErrorHandling$.wideConvert(ErrorHandling.scala:17)
        at sbt.Execute.work(Execute.scala:237)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.Execute$$anonfun$submit$1.apply(Execute.scala:228)
        at sbt.ConcurrentRestrictions$$anon$4$$anonfun$1.apply(ConcurrentRestrictions.scala:159)
        at sbt.CompletionService$$anon$2.call(CompletionService.scala:28)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
        at java.lang.Thread.run(Thread.java:745)
Caused by: com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
        at com.datastax.driver.core.Responses$Error.asException(Responses.java:132)
        at com.datastax.driver.core.DefaultResultSetFuture.onSet(DefaultResultSetFuture.java:179)
        at com.datastax.driver.core.RequestHandler.setFinalResult(RequestHandler.java:184)
        at com.datastax.driver.core.RequestHandler.access$2500(RequestHandler.java:43)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.setFinalResult(RequestHandler.java:798)
        at com.datastax.driver.core.RequestHandler$SpeculativeExecution.onSet(RequestHandler.java:617)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:1005)
        at com.datastax.driver.core.Connection$Dispatcher.channelRead0(Connection.java:928)
        at io.netty.channel.SimpleChannelInboundHandler.channelRead(SimpleChannelInboundHandler.java:105)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.timeout.IdleStateHandler.channelRead(IdleStateHandler.java:266)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.MessageToMessageDecoder.channelRead(MessageToMessageDecoder.java:103)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.handler.codec.ByteToMessageDecoder.fireChannelRead(ByteToMessageDecoder.java:276)
        at io.netty.handler.codec.ByteToMessageDecoder.channelRead(ByteToMessageDecoder.java:263)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:318)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:304)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:846)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:131)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:511)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:468)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:382)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:354)
        at io.netty.util.concurrent.SingleThreadEventExecutor$2.run(SingleThreadEventExecutor.java:112)
        at java.lang.Thread.run(Thread.java:745)
[error] (*:migrate) com.datastax.driver.core.exceptions.SyntaxError: line 8:0 missing EOF at 'CREATE' (... KEY (id))-- stage: 2[CREATE] TABLE...)
```

System: 
macOS Sierra Version 10.12.2

```java -version
   java version "1.8.0_111"
   Java(TM) SE Runtime Environment (build 1.8.0_111-b14)
   Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)
```

cassandra:3.7

Integration method: sbt-pillar plugin 2.1.1 - https://github.com/inoio/sbt-pillar-plugin
Pillar version: pillar_2.10-3.0.0.jar
