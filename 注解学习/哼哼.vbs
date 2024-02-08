Do
    userChoice = MsgBox("Will you marry me?", vbYesNo + vbQuestion, ":)")
    If userChoice = vbNo Then
        MsgBox "imma ask again", vbExclamation, "re-try"
    End If
Loop While userChoice = vbNo

MsgBox "Nahhh nvm ", vbInformation, "YAY"
