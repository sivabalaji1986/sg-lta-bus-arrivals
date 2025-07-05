This project is part of a multi-service architecture that enables an AI agent (such as Claude Desktop) to fetch real-time bus arrival timings from the LTA DataMall via a clean MCP abstraction.

- **`sg-lta-mcp-server`**: Exposes MCP tools via the Spring AI MCP server and delegates bus arrival requests to a downstream service using Feign.
- **`sg-lta-bus-arrivals`**: A standalone Spring Boot service that connects to the actual LTA Datamall API and returns real-time bus arrival information.


## Features
- `/api/bus-arrivals` endpoint to fetch upcoming bus timings by stop and service
- Integration with [LTA Datamall API](https://datamall.lta.gov.sg/)
- `RestTemplate`-based HTTP client
- Swagger/OpenAPI UI at `/swagger-ui.html`
- Clean separation of controller, service, and gateway
- Annotated with `@Schema` for AI tool compatibility
- MCP-friendly OpenAPI structure
- Customizable OpenAPI server URL via properties

---

## 📦 API Usage

**GET /api/bus-arrivals?busStopCode=96371&serviceNo=20**

Returns:
```json
{
  "BusStopCode": "96371",
  "Services": [
    {
      "ServiceNo": "20",
      "NextBus": {
        "EstimatedArrival": "2025-07-03T10:28:06+08:00",
        "Load": "SEA",
        "Feature": "WAB",
        "Type": "DD"
      }
    }
  ]
}
```

# To Run the Application
java -DLTA_API_KEY=your-api-key -jar sg-lta-bus-arrivals-1.0.0.jar

# To Access the openAPI spec
http://localhost:8688/api/v3/api-docs

# To download the openAPI spec in YAML format
http://localhost:8688/api/v3/api-docs.yaml

# To Access the Swagger UI
http://localhost:8688/api/swagger-ui/index.html
![Swagger.png](resources/Swagger.png)

# To access health check URL
http://localhost:8688/api/actuator/health