package com.example.androidparserplugin.action;

import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.editor.Editor;
import org.jetbrains.annotations.NotNull;

public class AndroidActionGroup extends DefaultActionGroup {

    @Override
    public void update(@NotNull AnActionEvent event) {
        //super.update(event);
        Editor editor = event.getData(CommonDataKeys.EDITOR);
        event.getPresentation().setEnabled(editor != null);
        //event.getPresentation().setIcon(SdkIcons.money);
    }
}
