# LogLibrary

The library for the purpose suggested in class...
To use the library you need know the executable class and the list class must be binded with log values.

1.First step:

Create de LogAux class, that contains the list to bind with log values. On LogAux.DESTINATION select one of values from LogDestination with:
LogDestination.CONSOLE; LogDestination.DATABASE; LogDestination.IOFILE; LogDestination.HTTPLOG;

2.Second step:

Create the LogWriter instance and execute the LogWriter.LogWrite(LogAux), like:
LogWriter instance = new LogWriter(); Boolean result = instance.LogWrite(LogAux);

3.Example of use this:

    LogAux log = new LogAux();
    log.MESSAGE = "The tests result is completed and successful...";
    log.LEVEL = "1";
    log.TIMESTAMP = LocalDateTime.now().toString();
    log.DESTINATION = LogDestination.CONSOLE;
    LogWriter instance = new LogWriter();
    Boolean expResult = false;
    Boolean result = instance.LogWrite(log);
    System.out.println("LogWrite to Console is successful...");
