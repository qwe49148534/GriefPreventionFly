package main.yaml;

import org.jetbrains.annotations.NotNull;

public final class PluginConfig
        extends PluginYamlObject {

    public static final String JOIN_MESSAGE_PATH = "JoinEventMessage";

    public static final String LEAVE_MESSAGE_PATH = "LeaveEventMessage";

    public PluginConfig() {
        super("Config.yml");
    }

    @NotNull
    public String getJoinMessage() {
        final String joinEventMessage = this.configuration.getString(PluginConfig.JOIN_MESSAGE_PATH);
        if (this.equalsStringNull(joinEventMessage))
            return joinEventMessage;

        return "ERROR MESSAGE";
    }

    @NotNull
    public String getLeaveMessage() {
        final String leaveEventMessage = this.configuration.getString(PluginConfig.LEAVE_MESSAGE_PATH);
        if (this.equalsStringNull(leaveEventMessage))
            return leaveEventMessage;

        return "ERROR MESSAGE";
    }

    private boolean equalsStringNull(final String msg) {
        return (msg != null);
    }

}
