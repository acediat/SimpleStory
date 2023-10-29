package ru.acediat.engine.common

enum class BuildType(
    val logsEnabled: Boolean,
) {
    DEBUG(logsEnabled = true),
    RELEASE(logsEnabled = false),
    UNKNOWN(logsEnabled = false),
}