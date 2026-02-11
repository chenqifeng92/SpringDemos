package org.spring.perf;

import com.sun.net.httpserver.HttpServer;
import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;

/**
 * 性能测试示例：使用 Gatling 对 demo HTTP 接口进行并发压测。
 *
 * 为了在 CI 环境独立运行，这里启动了一个轻量本地 HTTP server，
 * 再用 Gatling 压测其 /api/workers 端点。
 */
public class WorkersApiSimulation extends Simulation {

    private static HttpServer server;

    static {
        try {
            startServer();
        } catch (IOException e) {
            throw new RuntimeException("failed to start perf test server", e);
        }
    }

    private static void startServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress(18080), 0);
        server.createContext("/api/workers", exchange -> {
            byte[] body = "[{\"id\":1,\"name\":\"perf-worker\"}]".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, body.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(body);
            }
        });
        server.start();
    }

    {
        HttpProtocolBuilder httpProtocol = http
                .baseUrl("http://localhost:18080")
                .acceptHeader("application/json");

        ScenarioBuilder readWorkers = scenario("read workers")
                .exec(http("get workers")
                        .get("/api/workers")
                        .check(status().is(200))
                        .check(jsonPath("$[0].name").is("perf-worker")));

        setUp(
                readWorkers.injectOpen(rampUsers(30).during(10))
        ).protocols(httpProtocol);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (server != null) {
                server.stop(0);
            }
        }));
    }
}
