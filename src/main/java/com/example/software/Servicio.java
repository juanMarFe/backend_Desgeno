package com.example.software;
import com.example.software.controlador.Facade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.concurrent.CompletableFuture;

@Service
public class Servicio {
    private static final Logger LOGGER = LoggerFactory.getLogger(Servicio.class);

    @Async
    public CompletableFuture<Facade> guardarTrabajador(final InputStream inputStream) throws Exception {
        final long start = System.currentTimeMillis();
        LOGGER.info("1");
        LOGGER.info("Elapsed time: {}", (System.currentTimeMillis() - start));
        return CompletableFuture.completedFuture(Facade.crearInstaSingleton());
    }
}
