package com.example.androidparserplugin.action;

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
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project currentProject = e.getProject();
        StringBuilder dlgMsg = new StringBuilder(e.getPresentation().getText() + " Selected!");
        String dlgTitle = e.getPresentation().getDescription();
        Navigatable nav = e.getData(CommonDataKeys.NAVIGATABLE);
        if (nav != null) {
            dlgMsg.append(String.format("\nSelected Element: %s", nav));
        }
        Messages.showMessageDialog(currentProject, dlgMsg.toString(), dlgTitle, Messages.getInformationIcon());
    }

    @Override
    public void update(@NotNull AnActionEvent e) {
        super.update(e);
        Project project = e.getProject();
        e.getPresentation().setEnabledAndVisible(project != null);
    }
}
