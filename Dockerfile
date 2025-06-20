FROM openjdk:21-slim

# Set working directory
WORKDIR /app

# Copy JAR dan launcher
COPY target/credit_simulator-jar-with-dependencies.jar credit_simulator.jar
COPY credit_simulator credit_simulator

# Ubah menjadi executable (pastikan credit_simulator pakai LF, bukan CRLF!)
RUN chmod +x credit_simulator

# Jalankan script yang memanggil java -jar
ENTRYPOINT ["./credit_simulator"]
