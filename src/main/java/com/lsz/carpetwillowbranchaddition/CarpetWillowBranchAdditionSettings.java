package com.lsz.carpetwillowbranchaddition;

import carpet.api.settings.Rule;

public class CarpetWillowBranchAdditionSettings {

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
    public static int carpetCommandPermission = -1;
}
