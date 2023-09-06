import { defineConfig } from "vite";
import react from "@vitejs/plugin-react";

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  root: "src/main/ts",
  build: {
    // generate manifest.json in outDir
    manifest: false,
    rollupOptions: {
      // overwrite default .html entry
      input: "src/main/ts/main.tsx",
      output: {
        dir: "src/main/resources/static/bundle",
        entryFileNames: "[name].js",
        assetFileNames: "[name][extname]"
      }
    }
  },
  server: {
    origin: "http://localhost:8080"
  }
});
