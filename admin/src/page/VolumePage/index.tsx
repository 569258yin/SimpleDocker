import {Button, Divider, message, Space, Table, Tag} from "antd";
import {useEffect, useState} from "react";
import {AppstoreAddOutlined, CloudSyncOutlined, ReloadOutlined} from '@ant-design/icons'
import {ColumnsType} from "antd/es/table";
import InspectVolume from "../../api/Model/Volumn/InsepectVolume";
import {getVolumes} from "../../api/Volumes/Volumes";
import IconFont from "../../component/Base/IconFont";
import Search from "antd/es/input/Search";


function VolumePage() {

  const columns: ColumnsType<InspectVolume> = [
    {
      title: 'ID',
      dataIndex: 'Name',
      key: 'Name',
      fixed:'left',
      render: Name => <span>{!!Name && Name.substring(0, 10)}</span>,
      ellipsis: true,
      width: 150,
    },
    {
      title: '作用域',
      dataIndex: 'Scope',
      render: Scope => <span>{Scope.toUpperCase()}</span>,
      key: 'Scope',
      width: 100,
    }, {
      title: '挂载点',
      dataIndex: 'Mountpoint',
      render: Mountpoint => <span>{Mountpoint}</span>,
      ellipsis:true,
      key: 'Mountpoint'
    },
    {
      title: '创建时间',
      dataIndex: 'CreatedAt',
      key: 'CreatedAt',
      width: 200,
      render: CreatedAt => <span>{CreatedAt}</span>,
    },
    {
      title: '操作',
      dataIndex: 'address',
      key: 'address 4',
      fixed: 'right',
      width: 200,
      render: (_, image: InspectVolume) => {
        return (
            <Space>
              <Button size={"small"}>绑定</Button>
              <Button size={"small"}>详情</Button>
              <Button danger type={"ghost"} size={"small"}> 删除</Button>
            </Space>
        )
      }

    },
  ];


  let [volumes, setVolumes] = useState<Array<InspectVolume>>([])
  useEffect(() => {
    refresh()
  }, [])

  let refresh = () => {
    getVolumes().then(resp => {
      if (resp.code !== 0) {
        message.error(`加载储存卷列表失败:${resp.msg}`).then();
        return
      }
      setVolumes(resp.data.Volumes)
    })
  }

  return (
      <div id="imagePage" className={"box"}>
        <div>
          <div className="imageController inline">
            <Search placeholder="input search text" style={{width: 400}}/>
            <Button onClick={refresh} className="ml-2" icon={<ReloadOutlined/>}>刷新</Button>
            <Button className="ml-2" icon={<AppstoreAddOutlined/>} >新增</Button>
            <Button className="ml-2" icon={<CloudSyncOutlined/>} danger>清理</Button>
          </div>
        </div>
        <Table
            columns={columns}
            rowSelection={{fixed: 'left', type: 'checkbox'}}
            scroll={{x: 1000}}
            dataSource={volumes}
            size={"small"}/>
      </div>
  )
}

export default VolumePage;