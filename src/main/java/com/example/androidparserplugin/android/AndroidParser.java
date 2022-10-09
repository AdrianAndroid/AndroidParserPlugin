package com.example.androidparserplugin.android;

import com.android.tools.idea.gradle.dsl.GradleUtil;
import com.android.tools.idea.gradle.util.AndroidGradleSettings;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;

import java.io.File;

public class AndroidParser {

    private final AnActionEvent event;
    private final Project project;

    public AndroidParser(AnActionEvent event) {
        this.event = event;
        project = event.getProject();
    }

    /**
     * 测试GradleUtil.getBaseDirPath(project)
     */
    public void test1() {
        File baseDirPath = GradleUtil.getBaseDirPath(project);
        Project currentProject = event.getProject();
        StringBuilder dlgMsg = new StringBuilder(event.getPresentation().getText() + " Selected!");
        String dlgTitle = event.getPresentation().getDescription();
        Navigatable nav = event.getData(CommonDataKeys.NAVIGATABLE);
        if (nav != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", nav));
        }
        dlgMsg.append(baseDirPath.getAbsolutePath());
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());
    }

    /**
     * 测试是不是安卓项目
     */
    public void test2() {
        File baseDirPath = GradleUtil.getBaseDirPath(project);
        StringBuilder sb = new StringBuilder();
        boolean androidSdkDirInLocalPropertiesFile = AndroidGradleSettings.isAndroidSdkDirInLocalPropertiesFile(baseDirPath);
        sb.append("⭐️ 是不是安卓项目 : ").append(androidSdkDirInLocalPropertiesFile ? "是" : "不是").append("\n");
        String androidHomeFromLocalPropertiesFile = AndroidGradleSettings.getAndroidHomeFromLocalPropertiesFile(baseDirPath);
        sb.append("⭐️ getAndroidHomeFromLocalPropertiesFile : ").append(androidHomeFromLocalPropertiesFile).append("\n");
        Messages.showMessageDialog(sb.toString(), "是不是android项目", null);
    }

    public void run() {

        test2();
        // test1(); // 测试GradleUtil
    }
}
