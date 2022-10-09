package com.example.androidparserplugin.action;

import com.example.androidparserplugin.android.AndroidParser;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.pom.Navigatable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PopupDialogAction extends AnAction {
    public PopupDialogAction() {
        super();
    }

    public PopupDialogAction(@Nullable String text, @Nullable String description, @Nullable Icon icon) {
        super(text, description, icon);
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        AndroidParser androidParser = new AndroidParser(event);
        androidParser.run();
//        Project currentProject = event.getProject();
//        StringBuilder dlgMsg = new StringBuilder(event.getPresentation().getText() + " Selected!");
//        String dlgTitle = event.getPresentation().getDescription();
//        Navigatable nav = event.getData(CommonDataKeys.NAVIGATABLE);
//        if (nav != null) {
//            dlgMsg.append(String.format("\nSelected Element: %s", nav));
//        }
//        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }
}
