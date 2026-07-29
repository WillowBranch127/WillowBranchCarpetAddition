package com.lsz.willowbranchcarpetaddition;

import carpet.api.settings.Rule;

public class WillowBranchCarpetAdditionSettings {

    @Rule(
            categories = {"willowbranch"}
    )

    public static boolean startFreeze=false;

    @Rule(
            categories = {"willowbranch"},
            options = {"-1","0", "1", "2", "3", "4"}
    )
    public static int seedCommandPermission = -1;

    @Rule(
            categories = {"willowbranch"},
            options = {"-1","0", "1", "2", "3", "4"}
    )
    public static int locateCommandPermission = -1;

    @Rule(
            categories = {"willowbranch"},
            options = {"-1","0", "1", "2", "3", "4"}
    )
    public static int tickCommandPermission = -1;

    @Rule(
            categories = {"willowbranch"},
            options = {"-1","0", "1", "2", "3", "4"}
    )
    public static int dataCommandPermission = -1;
}
