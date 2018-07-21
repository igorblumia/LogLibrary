# LogLibrary

The library for the purpose suggested in class...

To use the library you need know the executable class must be binded with log values.

1.First step:

Create LogWriter instance of class.

LogWriter instance = new LogWriter();

2.Second step:

Call LogWriter.log to send message and level:

instance.log(message,level);

3.Third step:

You can write log on Console, File, Database or Http. To write log on Console:

Boolean result = instance.WriteLogOnConsole();

4.Examples:

4.1.Example of use this to write on file:

LogWriter instance = new LogWriter();

instance.log(message,level);

Boolean result = instance.WriteLogOnFile("log.txt");

4.2.Example of use this to write on Database:

LogWriter instance = new LogWriter();

instance.log(message,level);

Boolean result = instance.WriteLogOnDataBase();

4.3.Example of use this to write on Http service:

LogWriter instance = new LogWriter();

instance.log(message,level);

Boolean result = instance.WriteLogOnHttpPost("url");
