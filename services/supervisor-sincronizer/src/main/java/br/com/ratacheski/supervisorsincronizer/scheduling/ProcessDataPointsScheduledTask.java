package br.com.ratacheski.supervisorsincronizer.scheduling;

import de.re.easymodbus.exceptions.ModbusException;
import de.re.easymodbus.modbusclient.ModbusClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Random;

@EnableAsync
@Component
public class ProcessDataPointsScheduledTask {

    Logger logger = LogManager.getLogger(ProcessDataPointsScheduledTask.class);

    private static final String HOST = "localhost";
    private static final int PORT = 5020;

    @Async
    @Scheduled(fixedRate = 1000)
    public void processDataPoints() {
        logger.info("Implementation of obtaining measurements from data sources");
        PrintStream out = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
            }
        }));
        ModbusClient modbusClient;
        try {
            modbusClient = new ModbusClient(HOST, PORT);
        } finally {
            System.setOut(out);
        }
        try {
            modbusClient.Connect();
            logger.info("Connected to Modbus Server");
            modbusClient.WriteSingleRegister(getRandomNumber(0,10),getRandomNumber(1,200));
            var holdingRegisters = modbusClient.ReadHoldingRegisters(0, 10);
            logger.info("holdingRegisters: {}", Arrays.toString(holdingRegisters));
        } catch (IOException e) {
            logger.error("Cannot connect to Modbus Server: {}", e.getMessage());
        } catch (ModbusException e) {
            logger.error("Error reading Registers: {}", e.getMessage());
        }
    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
