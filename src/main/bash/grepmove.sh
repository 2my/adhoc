for x in $(find . -name "*.xml" -exec grep -l 'TimeSeriesIdentification v="BE' {} \;)
do
    mv $x ${x}.BE.xml
done

