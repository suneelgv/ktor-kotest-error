import io.kotest.assertions.ktor.shouldHaveHeader
import io.kotest.core.spec.style.FunSpec
import io.ktor.http.HttpMethod
import io.ktor.samples.simulateslowserver.module
import io.ktor.server.application.Application
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication

//import io.ktor.server.testing.handleRequest

class FailingSpec: FunSpec() {
    init {
        test("Failing at runtime") {
            withTestApplication(Application::module) {
                with(handleRequest(HttpMethod.Get, "https://www.google.com")){
                    response.shouldHaveHeader("Cache-Control", "max-age=1396")

                }
            }
        }
    }
}