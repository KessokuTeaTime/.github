#### 下北沢で

# <p>本</p><p>当、</p><p>有名のバンド。</p>

## Reusable Workflows

`visual-test.yml` launches staged Minecraft mods on Fabric and NeoForge through [MC-Runtime-Test](https://github.com/headlesshq/mc-runtime-test) and an isolated Xvfb display. It uploads in-game screenshots, logs, and crash reports without opening Minecraft on a developer workstation.

Calling repositories provide a `stageVisualTest` task in each loader subproject. The task must copy the production mod, a test-only screenshot driver, and runtime dependencies to `build/visual-test/<loader>/mods`. Fabric drivers use `fabric-client-gametest`; NeoForge drivers can use Minecraft's framebuffer screenshot API and an activation property passed through `neoforge-jvm-args`.
